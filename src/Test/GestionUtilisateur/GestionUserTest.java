package Test.GestionUtilisateur;

import GestionUtilisateur.GestionUser;
import Weapon.Weapon;
import Character.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class GestionUserTest {


    @Test
    void promptYesNo()  {
        GestionUser gestionUser = new GestionUser();
        provideInputString("Y");
        String input = gestionUser.promptYesNo("Coucou");
        assertEquals("Y", input);
        provideInputString("N");
        input = gestionUser.promptYesNo("Coucou");
        assertEquals("N", input);
    }

    @Test
    void promptMultiples(){
        GestionUser gestionUser = new GestionUser();
        provideInputString("Yes");
        provideInputString("Yty");
        provideInputString("Yrt");
        provideInputString("Y");
        String input = gestionUser.promptYesNo("Coucou");
        assertEquals("Y", input);
    }

    /**
     * Ce test vérifie que la méthode demande une nouvelle chaine de caractère non valide (!= de Y ou N)
     */
    @Test
    void promptYesNoExecption () {
        GestionUser gestionUser = new GestionUser();
        provideInputString("Yes");
        assertThrows(NoSuchElementException.class,() -> gestionUser.promptYesNo("Coucou"));
        provideInputString("5");
        assertThrows(NoSuchElementException.class,() -> gestionUser.promptYesNo("Coucou"));
    }

    @Test
    void multiplePrompteYesNo() {
        GestionUser gestionUser = new GestionUser();
        provideMultipleInputs("Yes", "No", "Feck","Y");
        String input = gestionUser.promptYesNo("Coucou");
        assertEquals("Y", input);
    }

    @Test
    void promptString() {
        GestionUser gestionUser = new GestionUser();
        provideInputString("Hello");
        String input = gestionUser.promptString("Coucou");
        assertEquals("Hello", input);

        provideInputString(" ");
        input = gestionUser.promptString("Coucou");
        assertEquals(" ", input);
    }

    @Test
    void string() {
        Hero hero = new Hero();
        Weapon weaponToCompare = hero.getArsenal().get("weaponChoice");
        assertNull(weaponToCompare);
    }

    /**
     * Methode permettant de simuler la saisie utilisateur
     * @param data : la chaine de caractère à tester
     */
    public void provideInputString(String data){
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    /**
     * Méthode pour simuler de multiples saisies
     * @param inputs
     */
    public void provideMultipleInputs(String... inputs) {
        for (String input : inputs) {
            provideInputString(input);
        }
    }

}