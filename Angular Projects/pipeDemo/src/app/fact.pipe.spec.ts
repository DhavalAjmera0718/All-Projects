import { FactPipe } from './fact.pipe';

describe('FactPipe', () => {
  it('create an instance', () => {
    const pipe = new FactPipe();
    expect(pipe).toBeTruthy();
  });
});
