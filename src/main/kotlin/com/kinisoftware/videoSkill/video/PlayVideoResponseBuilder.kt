package com.kinisoftware.videoSkill.video

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.kinisoftware.videoSkill.VIDEO_SUBTITLE
import com.kinisoftware.videoSkill.VIDEO_TITLE
import com.kinisoftware.videoSkill.VIDEO_URL

object PlayVideoResponseBuilder {
    fun buildVideoResponse(input: HandlerInput) = input.responseBuilder
            .addVideoAppLaunchDirective(
                    System.getenv(VIDEO_URL),
                    System.getenv(VIDEO_TITLE),
                    System.getenv(VIDEO_SUBTITLE)
            )
            .build()
}