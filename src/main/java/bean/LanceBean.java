package bean;

import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.LanceDao;
import entidade.Lance;

@ManagedBean
public class LanceBean {

	private Lance lance = new Lance();
	private List<Lance> lances;
	private Integer num1 = 0;
	private Integer num2 = 0;
	private Integer num3 = 0;
	private Integer num4 = 0;
	private Integer num5 = 0;
	private Integer total = 0;
	private Integer cont = 1;

	public Lance getLance() {
		return lance;
	}

	public void setLance(Lance lance) {
		this.lance = lance;
	}

	public List<Lance> getLances() {
		if (lances == null) {
			lances = LanceDao.listar();
		}
		return lances;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}

	public Integer getNum1() {
		return num1;
	}

	public void setNum1(Integer num1) {
		this.num1 = num1;
	}

	public Integer getNum2() {
		return num2;
	}

	public void setNum2(Integer num2) {
		this.num2 = num2;
	}

	public Integer getNum3() {
		return num3;
	}

	public void setNum3(Integer num3) {
		this.num3 = num3;
	}

	public Integer getNum4() {
		return num4;
	}

	public void setNum4(Integer num4) {
		this.num4 = num4;
	}

	public Integer getNum5() {
		return num5;
	}

	public void setNum5(Integer num5) {
		this.num5 = num5;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCont() {
		return cont;
	}

	public void setCont(Integer cont) {
		this.cont = cont;
	}

	public String gerar() {
		Random r = new Random();
		lance.setV1(r.nextInt(5) + 1);
		lance.setV2(r.nextInt(5) + 1);
		lance.setV3(r.nextInt(5) + 1);

		lance.setDescricao("Lance " + incremento());
		LanceDao.salvar(lance);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso",
				"Numeros gerados foram " + lance.getV1() + ", " + lance.getV2() + ", " + lance.getV3()));
		lance = new Lance();
		return null;
	}

	public String editar() {
		LanceDao.editar(lance);
		lance = new Lance();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso,", "Atualizado com sucesso"));
		return null;
	}

	public String excluir() {
		LanceDao.excluir(lance);
		lances.remove(lance);
		lance = new Lance();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso,", "Dados excluido com sucesso"));
		return null;
	}

	public void exibirQuantitativo() {
		this.num1 = 0;
		this.num2 = 0;
		this.num3 = 0;
		this.num4 = 0;
		this.num5 = 0;
		this.total = 0;

		for (Lance l : LanceDao.listar()) {

			if (l.getV1() == 1) {
				this.num1 = num1 + 1;
			}
			if (l.getV2() == 1) {
				this.num1 = num1 + 1;
			}
			if (l.getV3() == 1) {
				this.num1 = num1 + 1;
			}
			//
			if (l.getV1() == 2) {
				this.num2 = num2 + 1;
			}
			if (l.getV2() == 2) {
				this.num2 = num2 + 1;
			}
			if (l.getV3() == 2) {
				this.num2 = num2 + 1;
			}
			//

			if (l.getV1() == 3) {
				this.num3 = num3 + 1;
			}
			if (l.getV2() == 3) {
				this.num3 = num3 + 1;
			}
			if (l.getV3() == 3) {
				this.num3 = num3 + 1;
			}

			//

			if (l.getV1() == 4) {
				this.num4 = num4 + 1;
			}
			if (l.getV2() == 4) {
				this.num4 = num4 + 1;
			}
			if (l.getV3() == 4) {
				this.num4 = num4 + 1;
			}

			//

			if (l.getV1() == 5) {
				this.num5 = num5 + 1;
			}
			if (l.getV2() == 5) {
				this.num5 = num5 + 1;
			}
			if (l.getV3() == 5) {
				this.num5 = num5 + 1;
			}

			//

			this.total = this.num1 + this.num2 + this.num3 + this.num4 + this.num5;

		}

	}

	public Integer incremento() {

		for (Lance l : LanceDao.listar()) {
			if (l.getAux() == 0) {
				this.cont = cont + 1;
			}
		}
		return cont;
	}
}
