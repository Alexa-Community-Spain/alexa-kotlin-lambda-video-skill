package com.kinisoftware.videoSkill

import com.amazonaws.services.dynamodbv2.model.InternalServerErrorException

object Translations {

    enum class TranslationKey {
        WELCOME, HELP, THANKS, FALLBACK, NO_FEATURE, VIDEOAPP_NO_SUPPORTED
    }

    fun getMessage(language: String, messageKey: TranslationKey) =
            messages.getValue(language)[messageKey]
                    ?: throw InternalServerErrorException("There is not messages for $language - $messageKey")

    private val messages = mapOf(
            "es" to mapOf(
                    TranslationKey.WELCOME to "¡Gracias por usar esta skill!",
                    TranslationKey.HELP to "Para usar esta skill simplemente tienes que invocarla y reproducirá el video. ¿Quieres que lo reproduzca?",
                    TranslationKey.THANKS to "¡Gracias por usar esta skill!",
                    TranslationKey.FALLBACK to "Vaya, algo ha ido mal. Inténtalo más tarde",
                    TranslationKey.NO_FEATURE to "Vaya, no puedo cambiar de video, lo siento",
                    TranslationKey.VIDEOAPP_NO_SUPPORTED to "Vaya, parece que tu dispositivo Alexa no puede reproducir vídeo."
            ),
            "en" to mapOf(
                    TranslationKey.WELCOME to "Thank your for using this skill!",
                    TranslationKey.HELP to "To use this skill just invoke it and the video will be played right away. Do you want me to play the video now?",
                    TranslationKey.THANKS to "Thank your for using this skill!",
                    TranslationKey.FALLBACK to "Ups, there is some problem here. Please, try later again.",
                    TranslationKey.NO_FEATURE to "Ups, I cannot change the video. Sorry",
                    TranslationKey.VIDEOAPP_NO_SUPPORTED to "Ups, your Alexa device does not support to play videos."
            )
    )
}