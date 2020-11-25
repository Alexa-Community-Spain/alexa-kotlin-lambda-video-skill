package com.kinisoftware.videoSkill.handler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.request.Predicates.intentName
import com.kinisoftware.videoSkill.Translations
import com.kinisoftware.videoSkill.getLanguage

class FallbackIntentHandler : RequestHandler {

    override fun canHandle(input: HandlerInput) = input.matches(intentName("AMAZON.FallbackIntent"))

    override fun handle(input: HandlerInput) = input.responseBuilder
        .withSpeech(Translations.getMessage(input.getLanguage(), Translations.TranslationKey.FALLBACK))
        .withReprompt(Translations.getMessage(input.getLanguage(), Translations.TranslationKey.FALLBACK))
        .build()
}
