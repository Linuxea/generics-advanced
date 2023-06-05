package com.linuxea.covariant;

import java.util.List;

public interface Printer<T> {

    void print(List<? extends T> ts);
}
