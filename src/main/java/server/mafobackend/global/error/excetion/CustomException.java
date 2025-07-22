package server.mafobackend.global.error.excetion;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import server.mafobackend.global.error.ErrorCode;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;
}
