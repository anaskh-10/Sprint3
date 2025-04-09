//package com.Anas.Pc;
//
//import entities.Pc;
//import org.springframework.data.domain.Page;
//import repos.PcRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import service.PcService;
//
//import java.util.Date;
//import java.util.List;
//
//@SpringBootTest
//class PcApplicationTests {
//	@Autowired
//	private PcRepository pcRepository;
//	private PcService pcService;
//	@Test
//	public void testCreatePc(){
//		Pc p=new Pc();
//		p.setMarquePc("Dell");
//		p.setReferencePc("DELL-12345");
//		p.setPrixPc(1200.0);
//		p.setDateCreation(new Date());
//
//		pcRepository.save(p);
//	}
//	@Test
//	public void testFindPc(){
//		Pc p = pcRepository.findById(1L).get();
//		System.out.println(p);
//	}
//	@Test
//	public void testUpdatePc(){
//		Pc p=pcRepository.findById(1L).get();
//		p.setPrixPc(5000.0);
//		pcRepository.save(p);
//		System.out.println(p);
//	}
//	@Test
//	public void testDeletePc(){
//		pcRepository.deleteById(1L);
//	}
//	@Test
//	public void testListerTousPcs(){
//		List<Pc> pcs=pcRepository.findAll();
//		for (Pc p:pcs){
//			System.out.println(p);
//		}
//	}
//    @Test
//    public void testFindByNomPcContains()
//    {
//        Page<Pc> prods = pcService.getAllPcsParPage(0,2);
//        System.out.println(prods.getSize());
//        System.out.println(prods.getTotalElements());
//        System.out.println(prods.getTotalPages());
//        prods.getContent().forEach(p -> {System.out.println(p.toString());
//        });
///*ou bien
//for (Produit p : prods)
//{
//System.out.println(p);
//} */
//    }
//
//}
