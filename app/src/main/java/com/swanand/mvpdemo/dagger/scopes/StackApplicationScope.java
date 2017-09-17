package com.swanand.mvpdemo.dagger.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by swanand on 9/17/2017.
 */
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface StackApplicationScope {
}
