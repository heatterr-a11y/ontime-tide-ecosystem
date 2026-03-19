import React from 'react';
import { motion } from 'framer-motion';

/**
 * HeroSection for www.ontime-m.com
 * Visualizes the 120ms Synchronization Window and DTIF Framework.
 */
export default function HeroSection() {
  return (
    <div className="min-h-screen bg-[#02040a] text-white flex flex-col justify-center items-center overflow-hidden font-sans">
      
      {/* Background Glow Effect */}
      <div className="absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 w-[600px] h-[600px] bg-cyan-500/10 rounded-full blur-[120px]" />

      <motion.div 
        initial={{ opacity: 0, y: 20 }} 
        animate={{ opacity: 1, y: 0 }} 
        transition={{ duration: 1.2, ease: "easeOut" }}
        className="relative z-10 text-center px-6"
      >
        <div className="mb-6 inline-block px-4 py-1 rounded-full border border-cyan-500/20 bg-cyan-500/5 text-cyan-400 text-[10px] tracking-[0.3em] uppercase">
          TIDE Protocol Active: 120ms Sync
        </div>

        <h1 className="text-6xl md:text-8xl font-black tracking-tighter mb-6 bg-gradient-to-b from-white to-gray-500 bg-clip-text text-transparent">
          ONTIME-<span className="text-cyan-400">TIDE</span>
        </h1>

        <p className="max-w-xl mx-auto text-gray-400 text-lg md:text-xl font-light leading-relaxed mb-10">
          The Decentralized Temporal Intent Framework (DTIF) identifies the <span className="text-white italic">Absence of Action</span> to monetize the 1.8s window of peak human receptivity.
        </p>

        <div className="flex flex-col md:flex-row gap-4 justify-center items-center">
          <button className="px-8 py-4 bg-white text-black font-bold rounded-full hover:bg-cyan-400 transition-colors duration-300 w-full md:w-auto">
            View Whitepaper
          </button>
          <button className="px-8 py-4 border border-white/10 rounded-full hover:bg-white/5 transition-colors duration-300 w-full md:w-auto text-gray-300">
            Institutional Access
          </button>
        </div>
      </motion.div>

      {/* TISE Engine Status Bar */}
      <div className="absolute bottom-10 left-0 w-full px-10 flex justify-between items-center border-t border-white/5 pt-6 opacity-40">
        <div className="text-[9px] tracking-widest uppercase text-gray-500">
          TISE_ENGINE: <span className="text-green-500">OPERATIONAL</span>
        </div>
        <div className="text-[9px] tracking-widest uppercase text-gray-500">
          $ONTM_BURN_RATE: <span className="text-cyan-400">70%</span>
        </div>
        <div className="text-[9px] tracking-widest uppercase text-gray-500">
          RECEPTIVITY_VECTOR: <span className="text-white">SYNCHRONIZED</span>
        </div>
      </div>
    </div>
  );
}
