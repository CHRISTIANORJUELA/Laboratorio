package com.example.laboratory.utils;

import com.example.laboratory.models.Monitor;
import javafx.collections.ObservableList;

public interface StreamInterface {
    boolean filterPush(ObservableList<?> a, String document);
}
