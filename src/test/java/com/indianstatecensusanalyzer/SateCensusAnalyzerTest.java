package com.indianstatecensusanalyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class SateCensusAnalyzerTest {
    private static final String STATE_CENSUS_CSV_FILE_PATH = "E:\\Ebook\\BridgeLabz\\Assignment\\Indian States Census Analyzer\\StateCensusCSV.csv";

    @Test
    public void givenStateCensusCSVFile_ShouldReturnNumberOfRecords() {
        try {
            StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(Paths.get(STATE_CENSUS_CSV_FILE_PATH));
            int noOfEntries = censusAnalyzer.readStateCensusCSVData();
            Assertions.assertEquals(5, noOfEntries);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
