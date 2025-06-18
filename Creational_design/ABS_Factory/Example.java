package Creational_design.ABS_Factory;

// 1. Abstract Products (interfaces for each component type)
interface Button {
    void render();
    void onClick();
}

interface Checkbox {
    void render();
    void toggle();
}

interface Menu {
    void render();
    void addItem(String item);
}

// 2. Concrete Products for Windows Family
class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows-style button with blue theme");
    }
    
    public void onClick() {
        System.out.println("Windows button clicked - plays system sound");
    }
}

class WindowsCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering Windows checkbox with square design");
    }
    
    public void toggle() {
        System.out.println("Windows checkbox toggled with animation");
    }
}

class WindowsMenu implements Menu {
    public void render() {
        System.out.println("Rendering Windows menu with drop shadow");
    }
    
    public void addItem(String item) {
        System.out.println("Adding " + item + " to Windows menu");
    }
}

// 3. Concrete Products for Mac Family
class MacButton implements Button {
    public void render() {
        System.out.println("Rendering Mac-style button with rounded corners");
    }
    
    public void onClick() {
        System.out.println("Mac button clicked - subtle feedback");
    }
}

class MacCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering Mac checkbox with circular design");
    }
    
    public void toggle() {
        System.out.println("Mac checkbox toggled with smooth transition");
    }
}

class MacMenu implements Menu {
    public void render() {
        System.out.println("Rendering Mac menu with translucent background");
    }
    
    public void addItem(String item) {
        System.out.println("Adding " + item + " to Mac menu with fade-in");
    }
}

// 4. Abstract Factory Interface
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
    Menu createMenu();
}

// 5. Concrete Factories for each platform
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
    
    public Menu createMenu() {
        return new WindowsMenu();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
    
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
    
    public Menu createMenu() {
        return new MacMenu();
    }
}

// 6. Factory of Factories (chooses which factory to use)
class GUIFactoryProvider {
    public static GUIFactory getFactory(String platform) {
        switch (platform.toLowerCase()) {
            case "windows":
                return new WindowsFactory();
            case "mac":
                return new MacFactory();
            default:
                throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }
}

// 7. Client Code
public class Example {
    private GUIFactory factory;
    private Button button;
    private Checkbox checkbox;
    private Menu menu;
    
    public Example(String platform) {
        // Get the right factory for the platform
        this.factory = GUIFactoryProvider.getFactory(platform);
        
        // Create all components from the same family
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
        this.menu = factory.createMenu();
    }
    
    public void createUI() {
        // All components are guaranteed to be from the same platform family
        button.render();
        checkbox.render();
        menu.render();
        
        menu.addItem("File");
        menu.addItem("Edit");
        menu.addItem("View");
    }
    
    public static void main(String[] args) {
        // Create Windows version
        Example windowsApp = new Example("windows");
        System.out.println("=== Windows Application ===");
        windowsApp.createUI();
        
        System.out.println();
        
        // Create Mac version
        Example macApp = new Example("mac");
        System.out.println("=== Mac Application ===");
        macApp.createUI();
    }
}
