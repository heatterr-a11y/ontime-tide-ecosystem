package com.ontime.dtif;

import java.time.Instant;

/**
 * DTIF: Decentralized Temporal Intent Framework
 * Purpose: Monitors the "Silence" between user actions to calculate Intent Scarcity.
 * Core IP for: www.ontime-m.com
 */
public class IntentScarcityAlpha {
    
    // The proprietary 1.8-second threshold for "Absence of Action"
    private static final double ABSENCE_THRESHOLD_SEC = 1.8; 
    
    // Weighting factor for the Receptivity Vector (V)
    private static final double SCARCITY_WEIGHT = 0.85;

    /**
     * Analyzes the dwell time to determine if the 1.8s window has been reached.
     * @param lastActionTime The timestamp of the user's last interaction.
     * @param interactionDepth Number of previous steps in the session.
     * @return The calculated Scarcity Score (0.0 to 1.0).
     */
    public double calculateScarcity(Instant lastActionTime, int interactionDepth) {
        long currentTime = Instant.now().getEpochSecond();
        long dwellTime = currentTime - lastActionTime.getEpochSecond();

        if (dwellTime >= ABSENCE_THRESHOLD_SEC) {
            // Logic: Longer absence in a deep session = Higher Scarcity
            // This is the trigger for the 120ms TISE Engine.
            double rawScore = (dwellTime * interactionDepth) * SCARCITY_WEIGHT;
            return Math.min(rawScore, 1.0); // Capped at 1.0 (Peak Scarcity)
        }
        
        return 0.0; // No scarcity detected yet
    }

    public boolean isTriggerReady(double currentScarcity) {
        return currentScarcity >= 0.75; // Threshold to hand off to TISE Engine
    }
}
