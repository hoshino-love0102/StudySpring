package javastudy20250728.controller;

import javastudy20250728.service.MemberService;
import javastudy20250728.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String listMembers(Model model) {
        List<MemberDto> members = memberService.findAll();
        long count = memberService.countMembers();

        model.addAttribute("members", members);
        model.addAttribute("count", count);
        return "memberindex";
    }

    @GetMapping("/member/{id}")
    public String memberDetail(@PathVariable Long id, Model model) {
        MemberDto member = memberService.findById(id);
        model.addAttribute("member", member);
        return "membershow";
    }

    @GetMapping("/members/new")
    public String showCreateForm(Model model) {
        model.addAttribute("member", new MemberDto());
        return "memberform";
    }

    @PostMapping("/members")
    public String createMember(@ModelAttribute MemberDto memberDto) {
        memberService.save(memberDto);
        return "redirect:/members";
    }

    @GetMapping("/member/{id}/edit")
    public String editMemberForm(@PathVariable Long id, Model model) {
        MemberDto member = memberService.findById(id);
        model.addAttribute("member", member);
        return "memberedit";
    }

    @PostMapping("/member/{id}/edit")
    public String updateMember(@PathVariable Long id, @ModelAttribute MemberDto dto) {
        memberService.update(id, dto);
        return "redirect:/member/" + id;
    }

    @PostMapping("/member/{id}/delete")
    public String deleteMember(@PathVariable Long id) {
        memberService.delete(id);
        return "redirect:/members";
    }
}
