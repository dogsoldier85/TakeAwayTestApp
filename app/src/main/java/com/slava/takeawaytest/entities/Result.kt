package com.slava.takeawaytest.entities

data class Result<T>(val data: T? = null, val exception: Exception? = null)