package me.mattlogan.timberbug;

import timber.log.Timber;

public class Foo<T> {

    public void logBar(T bar) {
        Timber.d("bar: %s", bar);
    }
}
