package com.indianstatecensusanalyzer;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class SateCensusAnalyzerTest {
    private static final String STATE_CENSUS_CSV_FILE_PATH = "E:\\Ebook\\BridgeLabz\\Assignment\\Indian States Census Analyzer\\StateCensusCSV.csv";
    private static final String WRONG_CSV_FILE_PATH="E:\\Ebook\\BridgeLabz\\Assignment\\Indian States Census Analyzer\\src\\StateCensusCSV.csv";


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

    @Test
    public void givenStateCensusCSVFile_WhenPathIncorrect_ShouldThrowException() {
        try{
            StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(Paths.get(WRONG_CSV_FILE_PATH));
            censusAnalyzer.readStateCensusCSVData();
        }catch(StateCensusAnalyzerException e) {
            Assertions.assertEquals(StateCensusAnalyzerException.ExceptionType.INCORRECT_PATH, e.type);
        }
    }
}
