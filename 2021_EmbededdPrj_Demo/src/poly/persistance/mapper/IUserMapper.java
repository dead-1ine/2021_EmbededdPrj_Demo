package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.KakaoDTO;
import poly.dto.UserDTO;

@Mapper("UserMapper")
public interface IUserMapper {

	UserDTO getLoginInfo(UserDTO uDTO); // 일반적인 로그인 시도

	List<UserDTO> getUserList(UserDTO uDTO); // 유저 정보 가져오기

	KakaoDTO kakaoLoginForDgService(KakaoDTO pDTO); // 카카오 로그인을 통한 로그인 후 유저정보 가져오기
	
}
