package poly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.KakaoDTO;
import poly.dto.UserDTO;
import poly.persistance.mapper.IUserMapper;
import poly.service.IUserService;

@Service("UserService")
public class UserService implements IUserService{
	
	@Resource(name="UserMapper")
	private IUserMapper userMapper;

	@Override
	public UserDTO getLoginInfo(UserDTO uDTO) {
		
		return userMapper.getLoginInfo(uDTO);
	}

	@Override
	public KakaoDTO kakaoLoginForDgService(KakaoDTO pDTO) {

		return userMapper.kakaoLoginForDgService(pDTO);
	}
	
}
