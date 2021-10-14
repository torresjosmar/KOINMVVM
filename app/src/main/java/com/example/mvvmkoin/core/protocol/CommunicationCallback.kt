package com.coderio.pocmvvmandroid.common.protocol

interface CommunicationCallback {
    fun onFragmentEvent(action: ProtocolAction)
}