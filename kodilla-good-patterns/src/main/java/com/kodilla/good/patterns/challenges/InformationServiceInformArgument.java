package com.kodilla.good.patterns.challenges;

/**
 * Interface provides 2 methods: getUserName, getOrderToString.
 * Interface is used to restrict methods which are not substantial to process information service.
 * */
public interface InformationServiceInformArgument {

    String getUserName();
    String getOrderToString();
}
