import { Button, FormLabel, Input } from '@mui/joy';
import { useState } from 'react';
import { useMutation } from 'react-query';
import { useNavigate } from 'react-router-dom';
import { UserRessourceService } from '../state/api/generated';

export default function Login() {
  const navigate = useNavigate();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const loginMutation = useLoginMutation(email, password);
  return (
    <div>
      <form>
        <FormLabel>E-Mail</FormLabel>
        <Input value={email} onChange={(e) => setEmail(e.target.value)} />
        <FormLabel>password</FormLabel>
        <Input value={password} onChange={(e) => setPassword(e.target.value)} />
      </form>
      <Button onClick={() => loginMutation.mutate()}>Login</Button>
      <Button onClick={() => navigate('/internal')}>switch</Button>
    </div>
  );
}

const useLoginMutation = (email: string, password: string) => {
  const navigate = useNavigate();
  return useMutation({
    mutationFn: () => UserRessourceService.login({ email, password }),
    onSuccess: (data) => {
      localStorage.setItem('token', data.token);
      navigate('/internal');
    },
  });
};
