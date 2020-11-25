package com.kinisoftware.videoSkill

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.IntentRequest
import com.amazon.ask.model.LaunchRequest
import com.amazon.ask.model.RequestEnvelope
import com.amazonaws.services.dynamodbv2.model.InternalServerErrorException

object Utils {
    fun getLanguage(locale: String) = locale.substringBefore('-')
}

fun HandlerInput.getLanguage() =
    when (requestEnvelope.request) {
        is IntentRequest -> Utils.getLanguage((requestEnvelope.request as IntentRequest).locale)
        is LaunchRequest -> Utils.getLanguage((requestEnvelope.request as LaunchRequest).locale)
        else -> throw InternalServerErrorException("Error casting the input to get the locale")
    }

fun RequestEnvelope.getUserId() = context.system.user.userId.substringAfterLast('.')