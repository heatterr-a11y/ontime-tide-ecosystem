package com.ontime.tise;

import java.util.concurrent.CompletableFuture;

/**
 * TISE: Temporal Intent Synchronization Engine
 * Purpose: Processes the 3-Tuple Proxy (Stress, Aperture, Confidence) 
 * within the proprietary 120ms Micro-Decision Window.
 */
public class TISECoreEngine {

    // The critical 120ms execution window for real-time synchronization
    private static final long MICRO_WINDOW_MS = 120;

    /**
     * Synchronizes user intent data captured via DTIF.
     * @param stress User interaction velocity (S)
     * @param aperture Focus dwell-time (A)
     * @param confidence Stability of the "Absence" period (C)
     */
    public void synchronize(double stress, double aperture, double confidence) {
        long startTime = System.currentTimeMillis();

        // Calculate the Receptivity Vector (V)
        double receptivityVector = (stress + aperture + confidence) / 3;

        // Ensure the protocol executes before the user enters a "Dismissal State"
        CompletableFuture.runAsync(() -> {
            long elapsed = System.currentTimeMillis() - startTime;
            
            if (elapsed <= MICRO_WINDOW_MS) {
                // Success: Trigger the TIDE Protocol & $ONTM Settlement
                triggerTideProtocol(receptivityVector);
                System.out.println("TISE: Sync Success in " + elapsed + "ms");
            } else {
                // Fail: Latency exceeded the receptivity window
                System.out.println("TISE: Latency Error - Window Closed.");
            }
        });
    }

    private void triggerTideProtocol(double vector) {
        // This method connects to the OnTimeTideProtocol.sol (Blockchain Layer)
        System.out.println("TIDE: Protocol triggered with Vector V: " + vector);
    }
}
