package vn.edu.leading.kiemtra.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.leading.kiemtra.models.SinhVienModel;
import vn.edu.leading.kiemtra.services.SinhVienService;

import javax.validation.Valid;

@Controller
public class SinhVienController {

    private final SinhVienService sinhVienService;

    public SinhVienController(SinhVienService sinhVienService) {
        this.sinhVienService = sinhVienService;
    }

    @GetMapping("/")
    public String list (Model model){
        model.addAttribute("sinhViens",sinhVienService.findAll());
        return "list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("term") String term, Model model) {
        if (StringUtils.isEmpty(term)) {
            return "redirect:/";
        }
        model.addAttribute("sinhViens", sinhVienService.search(term));
        return "list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("sinhVienModel", new SinhVienModel());
        return "form";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("sinhVienModel", sinhVienService.findById(id));
        return "form";
    }

    @PostMapping("/save")
    public String save(@Valid SinhVienModel sinhVien, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        sinhVienService.save(sinhVien);
        redirect.addFlashAttribute("successMessage", "Saved category successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (sinhVienService.delete(id)) {
            redirect.addFlashAttribute("successMessage", "Deleted category successfully!");
            return "redirect:/";
        } else {
            redirect.addFlashAttribute("successMessage", "Not found!!!");
            return "redirect:/";
        }
    }
}
