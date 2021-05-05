package com.chatbot;

//import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
/*
Test class
 */
class PlayerTest {

    private Player initiator;
    private Player receiver;

    /*
    * Initialization of players initiator and receiver
    */
    @BeforeEach
    public void initializePlayers() {
        initiator = new PlayersChat("initiator");
        receiver = new PlayersChat("receiver");
    }

    /*
    * sending message from the initiator to receiver
     */
    @Test
    public void sendMessageToReceiver() {
        assertNotNull(initiator.sendMessageToPlayer(receiver, "Initiate game"));

    }

    /*
     * check the message received by the receiver and replied with the counter adn concatenated message back
     */
    @Test
    public void messageReceivedAndSentBackWithCounter() {
        String receivedMessage = initiator.sendMessageToPlayer(receiver, "Initiate game");
        assertEquals("Initiate game1", receivedMessage);
    }

    /*
    * check after sending and receiving the 10 messages, system exits gracefully
     */
    @Test
    public void exitAfter10MessagesSentAndReceived() {
        for (int i = 0; i < 100; i++) {
            initiator.sendMessageToPlayer(receiver, "Initiate game");
        }
    }

}