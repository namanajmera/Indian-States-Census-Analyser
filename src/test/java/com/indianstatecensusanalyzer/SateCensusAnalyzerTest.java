package com.indianstatecensusanalyzer;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class SateCensusAnalyzerTest {
    private static final String STATE_CENSUS_CSV_FILE_PATH = "E:\\Ebook\\BridgeLabz\\Assignment\\Indian States Census Analyzer\\StateCensusCSV.csv";
    private static final String WRONG_CSV_FILE_PATH="E:\\Ebook\\BridgeLabz\\Assignment\\Indian States Census Analyzer\\src\\StateCensusCSV.csv";
    private static final String CSV_FILE_WRONG_DELIMITER_PATH = "E:\\Ebook\\BridgeLabz\\Assignment\\Indian States Census Analyzer\\StateCensusCSVInvalidDelimiter.csv";
    private static final String CSV_FILE_WRONG_HEADER_PATH="E:\\Ebook\\BridgeLabz\\Assignment\\Indian States Census Analyzer\\StateCensusCSVInvalidHeader.csv";

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

    @Test
    public void givenStateCensusCSVFile_WhenStateIncorrect_ShouldThrowException() {
        try{
            StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(Paths.get(STATE_CENSUS_CSV_FILE_PATH));
            censusAnalyzer.readStateCensusCSVData();
        }catch(StateCensusAnalyzerException e) {
            Assertions.assertEquals(StateCensusAnalyzerException.ExceptionType.INCORRECT_STATE, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenIncorrectDelimeter_ShouldThrowException() {
        try{
            StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(Paths.get(CSV_FILE_WRONG_DELIMITER_PATH));
            censusAnalyzer.readStateCensusCSVData();
        }catch(StateCensusAnalyzerException e) {
            Assertions.assertEquals(StateCensusAnalyzerException.ExceptionType.INCORRECT_DELIMITER, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenIncorrectCSVHeader_ShouldThrowException() {
        try{
            StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(Paths.get(CSV_FILE_WRONG_HEADER_PATH));
            censusAnalyzer.readStateCensusCSVData();
        }catch(StateCensusAnalyzerException e) {
            Assertions.assertEquals(StateCensusAnalyzerException.ExceptionType.INCORRECT_CSV_HEADER, e.type);
        }
    }

    private static final String STATE_CODE_CSV_FILE_PATH = "E:\\Ebook\\BridgeLabz\\Assignment\\Indian States Census Analyzer\\StateCodeCSV.csv";
    private static final String WRONG_STATE_CODE_CSV_FILE_PATH = "E:\\Ebook\\BridgeLabz\\Assignment\\Indian States Census Analyzer\\src\\StateCodeCSV.csv";

    @Test
    public void givenStateCodeCSVFile_ShouldReturnNumberOfRecords() {
        try {
            StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(Paths.get(STATE_CODE_CSV_FILE_PATH));
            int noOfEntries = censusAnalyzer.readStateCodeCSVData();
            Assertions.assertEquals(7, noOfEntries);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenStateCodeCSVFile_WhenPathIncorrect_ShouldThrowException() {
        try {
            StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(Paths.get(WRONG_STATE_CODE_CSV_FILE_PATH));
            censusAnalyzer.readStateCodeCSVData();
        } catch (StateCensusAnalyzerException e) {
            Assertions.assertEquals(StateCensusAnalyzerException.ExceptionType.INCORRECT_PATH, e.type);
        }
    }

    @Test
    public void givenStateCodeCSVFile_WhenStateIncorrect_ShouldThrowException() {
        try {
            StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(Paths.get(STATE_CODE_CSV_FILE_PATH));
            censusAnalyzer.readStateCodeCSVData();
        } catch (StateCensusAnalyzerException e) {
            Assertions.assertEquals(StateCensusAnalyzerException.ExceptionType.INCORRECT_STATE, e.type);
        }
    }

}
