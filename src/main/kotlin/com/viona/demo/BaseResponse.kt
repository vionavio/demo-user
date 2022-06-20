package com.viona.demo


data class BaseResponse<T>(
        var status: Boolean = false,
        var message: String = "",
        var data: T
)