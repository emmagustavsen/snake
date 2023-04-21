package no.uib.inf101.sem2.snake.midi;

import java.io.InputStream;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

/**
 * This class is based on the TetrisSong-class from the previous assignment.
 * New song is taken from https://bitmidi.com
 * 
 * can be modified later to be generic, so that the player choose a song
 * 
 * @author Jasmine Næss
 */

public class Song implements Runnable {
    private static final String SONG = "mii_channel.mid";
    private Sequencer sequencer;

    @Override
    public void run() {
        InputStream song = Song.class.getClassLoader().getResourceAsStream(SONG);
        this.doPlayMidi(song, true);
    }

    public boolean songIsPlaying() {
        return this.sequencer != null && this.sequencer.isRunning();
    }

    private void doPlayMidi(final InputStream is, final boolean loop) {
        try {
            this.doStopMidiSounds();
            (this.sequencer = MidiSystem.getSequencer()).setSequence(MidiSystem.getSequence(is));
            if (loop) {
                this.sequencer.setLoopCount(-1);
            }
            this.sequencer.open();
            this.sequencer.start();
        }
        catch (Exception e) {
            this.midiError("" + e);
        }
    }

    public void doStopMidiSounds() {
        try {
            if (this.sequencer == null || !this.sequencer.isRunning()) {
                return;
            }
            this.sequencer.stop();
            this.sequencer.close();
        }
        catch (Exception e) {
            this.midiError("" + e);
        }
        this.sequencer = null;
    }

    public void doPauseMidiSounds() {
        try {
            if (this.sequencer == null || !this.sequencer.isRunning()) {
                return;
            }
            this.sequencer.stop();
        }
        catch (Exception e) {
            this.midiError("" + e);
        }
    }
    
    public void doUnpauseMidiSounds() {
        try {
            if (this.sequencer == null) {
                return;
            }
            this.sequencer.start();
        }
        catch (Exception e) {
            this.midiError("" + e);
        }
    }

    private void midiError(final String msg) {
        System.err.println("Midi error: " + msg);
        this.sequencer = null;
    }
}
