package java100.app.service;

public interface FacebookService {
    <T> T me(String accessToken, Class<T> type);
}
