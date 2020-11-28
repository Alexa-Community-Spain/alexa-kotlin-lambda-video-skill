package com.kinisoftware.videoSkill.handler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.LaunchRequest
import com.amazon.ask.request.Predicates
import com.amazon.ask.util.JacksonSerializer
import com.kinisoftware.videoSkill.Translations
import com.kinisoftware.videoSkill.getLanguage
import com.kinisoftware.videoSkill.getUserId
import com.kinisoftware.videoSkill.supportVideoApp
import com.kinisoftware.videoSkill.video.PlayVideoResponseBuilder

class PlayTheVideoHandler : RequestHandler {

    override fun canHandle(input: HandlerInput) =
            input.matches(Predicates.intentName("AMAZON.YesIntent"))
                    .or(
                            input.matches(Predicates.requestType(LaunchRequest::class.java))
                                    .or(input.matches(Predicates.intentName("PlayTheVideoIntent")))
                    )

    override fun handle(input: HandlerInput) =
            if (input.supportVideoApp()) {
                println("Context: ${JacksonSerializer().serialize(input.requestEnvelope)} for ${input.requestEnvelope.getUserId()}")
                PlayVideoResponseBuilder.buildVideoResponse(input)
            } else {
                input.responseBuilder
                        .withSpeech(Translations.getMessage(input.getLanguage(), Translations.TranslationKey.VIDEOAPP_NO_SUPPORTED))
                        .withShouldEndSession(true)
                        .build()
            }
}
