package com.kinisoftware.videoSkill

import com.amazon.ask.SkillStreamHandler
import com.amazon.ask.Skills
import com.kinisoftware.videoSkill.handler.CancelAndStopIntentHandler
import com.kinisoftware.videoSkill.handler.FallbackIntentHandler
import com.kinisoftware.videoSkill.handler.HelpIntentHandler
import com.kinisoftware.videoSkill.handler.PlayTheVideoHandler
import com.kinisoftware.videoSkill.handler.SessionEndedRequestHandler
import com.kinisoftware.videoSkill.handler.SystemExceptionEncounterHandler
import com.kinisoftware.videoSkill.interceptor.LogRequestInterceptor
import com.kinisoftware.videoSkill.interceptor.LogResponseInterceptor

class VideoSkillStreamHandler : SkillStreamHandler(skill) {
    companion object {
        private val skill = Skills.standard()
                .addRequestInterceptor(LogRequestInterceptor())
                .addResponseInterceptor(LogResponseInterceptor())
                .addRequestHandlers(
                        PlayTheVideoHandler(),
                        HelpIntentHandler(),
                        CancelAndStopIntentHandler(),
                        FallbackIntentHandler(),
                        SystemExceptionEncounterHandler(),
                        SessionEndedRequestHandler()
                )
                .build()
    }
}
