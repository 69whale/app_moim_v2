package org.edupoll.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.edupoll.model.dto.response.AttendanceJoinResponseData;
import org.edupoll.model.dto.response.FollowResponseData;
import org.edupoll.model.entity.Attendance;
import org.edupoll.model.entity.Follow;
import org.edupoll.model.entity.Moim;
import org.edupoll.model.entity.User;
import org.edupoll.repository.FollowRepository;
import org.edupoll.repository.UserRepository;
import org.hibernate.ObjectDeletedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FollowService {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FollowRepository followRepository;
	
	
	// 누군가 누구를 팔로우하고자 할때 그걸 처리할 서비스 메서드
		public FollowResponseData createFollow(String ownerId, String targetId) {
			if(followRepository.existsByOwnerIdAndTargetId(ownerId, targetId)) {
				// 실패를 알리는 DTO 리턴 ... .. 바로 ResponseBody 로 나갈꺼니 객체로 리턴하는게 좋을 듯 
				return new FollowResponseData(false);
			}else {
				Follow f = new Follow();
				f.setOwner(userRepository.findById(ownerId).get());	// 100 프로 있다고 가정했음
				f.setTarget(userRepository.findById(targetId).get());	// 오류의 원인이 될 가능성이 존재함
				f.setCreated(new Date());
				followRepository.save(f);
				return new FollowResponseData(true);
			}
		}
		
	// ownerId와 targetId 일치할 때	
	
	
	// 누군가 누구를 언팔로우 하고자 할때 그걸 처리할 서비스 메서드
		public FollowResponseData deleteFollow(String ownerId, String targetId) {
			
			Follow deleted = followRepository.deleteByOwnerIdAndTargetId(ownerId, targetId);
			if(followRepository.findByOwnerIdAndTargetId(ownerId, targetId)) {
				
				
				return new FollowResponseData(false);
				//실패를 알리는 DTO 리턴
			} else {
				followRepository.save(deleted);
				return new FollowResponseData(true);
				//성공을 알리는 DTO 리턴
			}
		}
		
		
	
}
