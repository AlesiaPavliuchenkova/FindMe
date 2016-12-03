package com.app.servlet.DTO;

import com.app.servlet.DTO.PersonDTO;

import java.util.ArrayList;

/**
 * Created by apavliuchenkova on 04/11/2016.
 */
public class ProfileDTO {
    PersonDTO person;
    //some additional info ///may be some preferences of person (sport activity, movie, photo etc)
    ArrayList<MessageDTO> messages;
    ArrayList<ProfileDTO> profiles;
    ArrayList<PhotoDTO> photos;
    //lock user for hiding his info
    //etc
    //how can I bind possibility to make call/video-call
}
