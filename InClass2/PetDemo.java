//Evan Swanson
//Inclass Assignment 2, 2/05/2019
//Class Pet demo
public class PetDemo
{
    public static void main(String[] args)
    {
        Pet pet1 = new Pet();
        pet1.setName("Oreo");
        pet1.setAnimal("Cat");
        pet1.setAge(3);
        System.out.println("Name: " + pet1.getName());
        System.out.println("Animal: " + pet1.getAnimal());
        System.out.println("Age: " + pet1.getAge());
    }
}