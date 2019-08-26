package com.rmakiyama.edittextsample

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import com.rmakiyama.edittextsample.ui.FeedbackLikeTwitterWatcher
import com.rmakiyama.edittextsample.ui.SimpleTextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupWatchablePattern()
        setupFeedbackLikeTwitterPattern()
    }

    private fun setupWatchablePattern() {
        input_watchable.addTextChangedListener(object : SimpleTextWatcher {
            override fun afterTextChanged(editable: Editable) {
                button_watchable.isEnabled =
                    editable.length <= resources.getInteger(R.integer.limit_edit_text_max_length)
            }
        })
    }

    private fun setupFeedbackLikeTwitterPattern() {
        val maxLength = resources.getInteger(R.integer.limit_edit_text_max_length)
        input_like_twitter.addTextChangedListener(FeedbackLikeTwitterWatcher(
            context = this, maxLength = maxLength
        ) { isOverMaxLength -> button_like_twitter.isEnabled = !isOverMaxLength }
        )
    }
}
