package com.example.javachat.chat.dto;


import lombok.Data;

import java.util.UUID;

@Data
public class RoomDTO {
    private String roomId;
    private String name;
    //private Set<WebSocketSession> sessions = new HashSet<>();

    /*@Builder
    public RoomDTO(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }

    public void handleActions(WebSocketSession session, MessageDTO chatMessage, ChatService chatService) {
        if (chatMessage.getType().equals(MessageDTO.MessageType.ENTER)) {
            sessions.add(session);
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");
        }
        if (chatMessage.getType().equals(MessageDTO.MessageType.TALK)) {
            sessions.add(session);
            chatMessage.setMessage(chatMessage.getSender() + ": "+chatMessage.getMessage());
        }
        sendMessage(chatMessage, chatService);
    }

    public <T> void sendMessage(T message, ChatService chatService) {
        sessions.parallelStream().forEach(session -> chatService.sendMessage(session, message));
    }*/


    public static RoomDTO create(String name) {
        RoomDTO chatRoom = new RoomDTO();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }
}
