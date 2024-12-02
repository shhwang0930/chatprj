package com.example.javachat.chat.repository;

import com.example.javachat.chat.dto.RoomDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

// import 생략....

@Repository
public class ChatRoomRepository {

    private Map<String, RoomDTO> chatRoomMap;

    @PostConstruct
    private void init() {
        chatRoomMap = new LinkedHashMap<>();
    }

    public List<RoomDTO> findAllRoom() {
        // 채팅방 생성순서 최근 순으로 반환
        List chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }

    public RoomDTO findRoomById(String id) {
        return chatRoomMap.get(id);
    }

    public RoomDTO createChatRoom(String name) {
        RoomDTO chatRoom = RoomDTO.create(name);
        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }
}