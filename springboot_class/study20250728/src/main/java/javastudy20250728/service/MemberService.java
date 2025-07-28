package javastudy20250728.service;

import javastudy20250728.dto.MemberDto;
import javastudy20250728.entity.Member;
import javastudy20250728.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberDto> findAll() {
        return memberRepository.findAll()
                .stream()
                .map(MemberDto::fromEntity)
                .collect(Collectors.toList());
    }

    public MemberDto findById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow();
        return MemberDto.fromEntity(member);
    }

    public void save(MemberDto dto) {
        Member member = Member.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
        memberRepository.save(member);
    }

    public long countMembers() {
        return memberRepository.count();
    }

    public void update(Long id, MemberDto dto) {
        Member member = memberRepository.findById(id).orElseThrow();
        member.setName(dto.getName());
        member.setEmail(dto.getEmail());
        memberRepository.save(member);
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
}
