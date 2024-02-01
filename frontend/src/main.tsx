import { ErrorBoundary, LEVEL_WARN, Provider } from '@rollbar/react';
import React from 'react';
import ReactDOM from 'react-dom/client';
import { QueryClient, QueryClientProvider } from 'react-query';
import { BrowserRouter } from 'react-router-dom';
import App from './App.tsx';
import './index.css';

const queryClient = new QueryClient();

const rollbarConfig = {
  accessToken: 'f2d37db91c134246bcf1a023ff862216',
  environment: 'production',
  hostBlockList: ['localhost:3000'],
};

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <Provider config={rollbarConfig}>
      <ErrorBoundary
        level={LEVEL_WARN}
        errorMessage="Error in React render"
        extra={(_, info) => (info.componentStack?.includes('Experimental') ? { experiment: true } : {})}>
        <BrowserRouter>
          <QueryClientProvider client={queryClient}>
            <App />
          </QueryClientProvider>
        </BrowserRouter>
      </ErrorBoundary>
    </Provider>
  </React.StrictMode>,
);
