package com.srk.demo.bitset;

import java.util.BitSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class BitSetDemo {
    private static Logger logger = LogManager.getLogger(BitSetDemo.class);
    public static void main(String[] args) {

	BitSet bitSet = new BitSet(8);
	bitSet.set(1);
	bitSet.set(2);
	bitSet.set(3);
	bitSet.set(8);
	logger.info("Hello " + bitSet.toString());
	logger.debug("", bitSet.toString());
    }

}
