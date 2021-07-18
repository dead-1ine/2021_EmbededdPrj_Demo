package poly.service;

import poly.dto.KakaoDTO;
import poly.dto.UserDTO;

public interface IUserService {

	UserDTO getLoginInfo(UserDTO uDTO); // 로그인 정보 입력                                                              

	KakaoDTO kakaoLoginForDgService(KakaoDTO pDTO); //  카카오 인증을 통해 받아온 이메일로 서비스 로그인 시도


}
