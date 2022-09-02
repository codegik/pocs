package com.codegik.poc.converter.domain

import com.codegik.poc.converter.annotation.Alias

class Neighbor(
    var name: String? = null,
    var lastName: String? = null,
    @Alias("email")
    var aim: String? = null)
