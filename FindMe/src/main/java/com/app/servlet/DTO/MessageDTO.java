package com.app.servlet.DTO;

/**
 * Created by apavliuchenkova on 25/11/2016.
 */
public class MessageDTO {
    private int messageId;
    private String messageText;
    private int receiverId;
    private int senderId;
    private boolean isRead;

    public MessageDTO(){}

    public MessageDTO(String messageText, int receiverId, int senderId, boolean isRead) {
        this.messageText = messageText;
        this.receiverId = receiverId;
        this.senderId = senderId;
        this.isRead = isRead;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "messageId=" + messageId +
                ", messageText='" + messageText + '\'' +
                ", receiverId=" + receiverId +
                ", senderId=" + senderId +
                ", isRead=" + isRead +
                '}';
    }
}
