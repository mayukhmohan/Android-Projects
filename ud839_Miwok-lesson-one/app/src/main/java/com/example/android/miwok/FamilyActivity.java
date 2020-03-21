/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
public class FamilyActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // Pause playback
                //The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus
                //short amount of time.The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means
                //our allowed to continue playing sound but at a lower volume.
                //both cases the same way becz our app is playing short sound files
                //pause playback and reset player to the start of he file.That Way,
                //play the word from the beginning when we resume playback.
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // Resume playback we've regained the focus
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                //We've lost audio focus and stop playback and cleanup resources
                releaseMediaPlayer();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<word> words=new ArrayList<word>();
        words.add(new word("әpә","father",R.drawable.family_father,R.raw.family_father));
        words.add(new word("әṭa","mother",R.drawable.family_mother,R.raw.family_mother));
        words.add(new word("angsi","son",R.drawable.family_son,R.raw.family_son));
        words.add(new word("tune","daughter",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new word("taachi","older brother",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new word("chalitti","younger brother",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new word("teṭe","older sister",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new word("kolliti","younger sister",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new word("ama","grandmother",R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new word("paapa","grandfather",R.drawable.family_grandfather,R.raw.family_grandfather));

        /*int counter=0;
        while (counter<words.size())
        {
            TextView wordView=new TextView(this);
            wordView.setText(words.get(counter));
            rootView.addView(wordView);
            counter++;
        }*/
        WordAdapter itemsAdapter = new WordAdapter(this,words,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(NumbersActivity.this,"Song",Toast.LENGTH_SHORT).show();
                word word=words.get(position);//Get the {@link word} object at the given position the user clicked on
                //Create and setup the {@link MediaPlayer}for the audio resource associated
                //with the current word
                releaseMediaPlayer();
                // Request audio focus for playback
                int result = audioManager.requestAudioFocus(audioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have an audio focus now

                    //Create and setup the {@link MediaPlayer}for the audio resource associated
                    //with the current word
                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());
                    //Start the audio file
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
            // Abandon audio focus when playback complete
            audioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }
}
