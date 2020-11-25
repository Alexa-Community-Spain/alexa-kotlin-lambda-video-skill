package com.kinisoftware.videoSkill.handler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.LaunchRequest
import com.amazon.ask.request.Predicates
import com.kinisoftware.videoSkill.video.PlayVideoResponseBuilder

class PlayTheVideoHandler : RequestHandler {

    override fun canHandle(input: HandlerInput) =
        input.matches(Predicates.intentName("AMAZON.YesIntent"))
            .or(
                input.matches(Predicates.requestType(LaunchRequest::class.java))
                    .or(input.matches(Predicates.intentName("PlayTheVideoIntent")))
            )

    override fun handle(input: HandlerInput) = PlayVideoResponseBuilder.buildVideoResponse(input)
}
