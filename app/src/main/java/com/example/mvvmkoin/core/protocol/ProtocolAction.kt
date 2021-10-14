package com.coderio.pocmvvmandroid.common.protocol

sealed class ProtocolAction {
    object OnConectionError: ProtocolAction()
    class OnEventName(val value: String): ProtocolAction()
}