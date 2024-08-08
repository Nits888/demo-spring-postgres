// ThemeContext.tsx
import React, { createContext, useState, useContext, ReactNode } from 'react';

// Define the shape of the theme context
interface ThemeContextType {
  theme: string;
  toggleTheme: () => void;
}

// Create the Theme Context
const ThemeContext = createContext<ThemeContextType | undefined>(undefined);

// ThemeProvider component to manage theme state
export const ThemeProvider = ({ children }: { children: ReactNode }) => {
  const [theme, setTheme] = useState('light');

  const toggleTheme = () => {
    setTheme((prevTheme) => (prevTheme === 'light' ? 'dark' : 'light'));
  };

  return (
    <ThemeContext.Provider value={{ theme, toggleTheme }}>
      {children}
    </ThemeContext.Provider>
  );
};

// Custom hook to use the theme context
export const useTheme = () => {
  const context = useContext(ThemeContext);
  if (!context) {
    throw new Error('useTheme must be used within a ThemeProvider');
  }
  return context;
};

// ThemeToggle.tsx
import React from 'react';
import { useTheme } from './ThemeContext';

const ThemeToggle = () => {
  const { theme, toggleTheme } = useTheme();

  return (
    <button onClick={toggleTheme}>
      Switch to {theme === 'light' ? 'Dark' : 'Light'} Theme
    </button>
  );
};

export default ThemeToggle;

// App.tsx
import React from 'react';
import { ThemeProvider } from './ThemeContext';
import ThemeToggle from './ThemeToggle';
import './styles.css'; // Import your CSS file for styling

const AppContent = () => {
  const { theme } = useTheme();

  return (
    <div className={theme === 'light' ? 'light-theme' : 'dark-theme'}>
      <h1>Hello, World!</h1>
      <ThemeToggle />
      {/* Other components can be added here */}
    </div>
  );
};

const App = () => (
  <ThemeProvider>
    <AppContent />
  </ThemeProvider>
);

export default App;
/* styles.css */
.light-theme {
  background-color: white;
  color: black;
}

.dark-theme {
  background-color: black;
  color: white;
}

/* Additional styles can be added here */
