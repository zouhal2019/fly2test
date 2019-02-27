/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.dtos;

/**
 *
 * @author aernst
 */
public class allDTODTO 
{
    private  FluggesellschaftDTO fgDTO;
    private  Fl_HerstellerDTO fl_HerstDTO;
    private  FlugzeugDTO flugzeugDTO;
    private  LinieDTO linDTO;
    private  AbfFlughafenDTO abFlDTO;
    private  AnkFlughafenDTO anFlDTO;
    private  FlugDTO fl_DTO;
    private  PassagierDTO passDTO;
    private  BuchungDTO buchDTO;

    public allDTODTO() {
    }

   
    
    
    
    public allDTODTO(FluggesellschaftDTO fgDTO, Fl_HerstellerDTO fl_HerstDTO, FlugzeugDTO flugzeugDTO, LinieDTO linDTO, AbfFlughafenDTO abFlDTO, AnkFlughafenDTO anFlDTO, FlugDTO fl_DTO, PassagierDTO passDTO, BuchungDTO buchDTO) {
        this.fgDTO = fgDTO;
        this.fl_HerstDTO = fl_HerstDTO;
        this.flugzeugDTO = flugzeugDTO;
        this.linDTO = linDTO;
        this.abFlDTO = abFlDTO;
        this.anFlDTO = anFlDTO;
        this.fl_DTO = fl_DTO;
        this.passDTO = passDTO;
        this.buchDTO = buchDTO;
    }

    public void setFgDTO(FluggesellschaftDTO fgDTO) {
        this.fgDTO = fgDTO;
    }

    public void setFl_HerstDTO(Fl_HerstellerDTO fl_HerstDTO) {
        this.fl_HerstDTO = fl_HerstDTO;
    }

    public void setFlugzeugDTO(FlugzeugDTO flugzeugDTO) {
        this.flugzeugDTO = flugzeugDTO;
    }

    public void setLinDTO(LinieDTO linDTO) {
        this.linDTO = linDTO;
    }

    public void setAbFlDTO(AbfFlughafenDTO abFlDTO) {
        this.abFlDTO = abFlDTO;
    }

    public void setAnFlDTO(AnkFlughafenDTO anFlDTO) {
        this.anFlDTO = anFlDTO;
    }

    public void setFl_DTO(FlugDTO fl_DTO) {
        this.fl_DTO = fl_DTO;
    }

    public void setPassDTO(PassagierDTO passDTO) {
        this.passDTO = passDTO;
    }

    public void setBuchDTO(BuchungDTO buchDTO) {
        this.buchDTO = buchDTO;
    }
    

    public FluggesellschaftDTO getFgDTO() {
        return fgDTO;
    }

    public Fl_HerstellerDTO getFl_HerstDTO() {
        return fl_HerstDTO;
    }

    public FlugzeugDTO getFlugzeugDTO() {
        return flugzeugDTO;
    }

    public LinieDTO getLinDTO() {
        return linDTO;
    }

    public AbfFlughafenDTO getAbFlDTO() {
        return abFlDTO;
    }

    public AnkFlughafenDTO getAnFlDTO() {
        return anFlDTO;
    }

    public FlugDTO getFl_DTO() {
        return fl_DTO;
    }

    public PassagierDTO getPassDTO() {
        return passDTO;
    }

    public BuchungDTO getBuchDTO() {
        return buchDTO;
    }
    
    
    
    
    
    
}
