package ru.practicum.ewm.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import ru.practicum.ewm.comment.dto.CommentShortDto;
import ru.practicum.ewm.event.Location;
import ru.practicum.ewm.event.enums.EventState;

import java.time.LocalDateTime;
import java.util.Collection;

@Setter
@Getter
public class EventFullDto {

    private Long id;
    private String annotation;
    private EventFullDto.CategoryDto category;
    private Long confirmedRequests;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdOn;
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate;
    private EventFullDto.UserShortDto initiator;
    private Location location;
    private Boolean paid;
    private Integer participantLimit;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishedOn;
    private Boolean requestModeration;
    private EventState state;
    private String title;
    private Long views;
    private Collection<CommentInnerDto> comments;

    @Setter
    @Getter
    public static class CategoryDto {

        private Long id;

        private String name;
    }

    @Setter
    @Getter
    public static class UserShortDto {

        private Long id;

        private String name;
    }

    @Setter
    @Getter
    public static class CommentInnerDto {

        private Long id;

        private String text;

        private CommentInnerDto.UserDto author;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdOn;

        @Setter
        @Getter
        public static class UserDto {

            private Long id;

            private String name;

            private String email;
        }
    }
}
