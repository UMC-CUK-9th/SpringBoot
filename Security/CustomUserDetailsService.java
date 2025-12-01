package com.example.demo.global.Security;

import com.example.demo.domain.members.entity.Members;
import com.example.demo.domain.members.exception.MemberException;
import com.example.demo.domain.members.exception.code.MemberErrorCode;
import com.example.demo.domain.members.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(
            String username
    ) throws UsernameNotFoundException {
        // 검증할 Member 조회
        Members member = memberRepository.findByEmail(username)
                .orElseThrow(() -> new MemberException(
                        MemberErrorCode.MEMBER_NOT_FOUND.getMessage()
                ));

        // CustomUserDetails 반환
        return new CustomUserDetails(member);
    }
}
