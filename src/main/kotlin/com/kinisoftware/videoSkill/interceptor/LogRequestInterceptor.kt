package com.kinisoftware.videoSkill.interceptor

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.interceptor.RequestInterceptor
import com.amazon.ask.util.JacksonSerializer
import com.kinisoftware.videoSkill.getUserId

class LogRequestInterceptor : RequestInterceptor {
    override fun process(input: HandlerInput) {
        println("Request: ${JacksonSerializer().serialize(input.request)} for ${input.requestEnvelope.getUserId()}")
        println("Context: ${JacksonSerializer().serialize(input.requestEnvelope)} for ${input.requestEnvelope.getUserId()}")
    }
}