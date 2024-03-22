//package com.assignmentevent.graphql.util;
//
//import com.netflix.graphql.dgs.DgsComponent;
//import com.netflix.graphql.dgs.DgsScalar;
//import graphql.schema.Coercing;
//import graphql.schema.CoercingParseValueException;
//import graphql.schema.CoercingSerializeException;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@DgsComponent
//@DgsScalar(name = "DateTime")
//
//public class DateTimeScalar implements Coercing<LocalDateTime, String> {
//    @Override
//    public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
//        if (dataFetcherResult instanceof LocalDateTime) {
//            return ((LocalDateTime) dataFetcherResult).toString();
//        } else {
//            throw new CoercingSerializeException("Expected LocalDateTime but was " + dataFetcherResult.getClass().getSimpleName());
//        }
//    }
//
//    @Override
//    public LocalDateTime parseValue(Object input) throws CoercingParseValueException {
//        try {
//            return LocalDateTime.parse((String) input);
//        } catch (Exception e) {
//            throw new CoercingParseValueException("Unable to parse input", e);
//        }
//
//
//    }
//}
//
//
//
